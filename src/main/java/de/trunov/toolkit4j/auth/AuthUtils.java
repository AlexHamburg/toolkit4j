/**
 * Copyright (C) 2019 Oleksandr Trunov. All rights reserved. 
 * https://github.com/AlexHamburg
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library. If not, see http://www.gnu.org/licenses/.
 */
package de.trunov.toolkit4j.auth;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.trunov.toolkit4j.exceptions.BadAuthResponseException;

/**
 * Helper methods in the work with Auth Keycloak server.
 */
public class AuthUtils {
	
	/**
	 * Utils shouldn't be created.
	 */
	private AuthUtils() {
		throw new UnsupportedOperationException("It is not allowed to create an instance of a utility class");
	}
	
	/**
	 * Login to Keycloak and returns the access token.
	 * 
	 * @param client	JAX-RS Client that should make POST Request to keycloak auth server.
	 * @param authUrl	Full Auth URL from keycloak 
	 * 					(for example: http://keycloak.example:8080/auth/realms/realm/protocol/openid-connect/token)
	 * @param grantType	Current grant type (for example: 'password')
	 * @param clientId	Current client id in the realm.
	 * @param userName	User.
	 * @param password	User's password.
	 * 
	 * @return Header value directly usable for the
	 *         javax.ws.rs.core.HttpHeaders.AUTHORIZATION header.
	 * @throws BadResponseException 
	 */
	public static String readAccessHeaderValue(final Client client, final String authUrl,
			final String grantType, final String clientId, final String userName, final String password) throws BadAuthResponseException {
		
		return "Bearer " + AuthUtils.getKeycloakAccessToken(client, authUrl, grantType, clientId, userName, password);
	}

	/**
	 * Login to Keycloak and returns the access token as String.
	 * 
	 * @param client	JAX-RS Client that should make POST Request to keycloak auth server.
	 * @param authUrl	Full Auth URL from keycloak 
	 * 					(for example: http://keycloak.example:8080/auth/realms/realm/protocol/openid-connect/token)
	 * @param grantType	Current grant type (for example: 'password')
	 * @param clientId	Current client id in the realm.
	 * @param userName	User.
	 * @param password	User's password.
	 * 
	 * @return	Auth token in the String representation.
	 * @throws BadResponseException 
	 */
	public static String getKeycloakAccessToken(final Client client, final String authUrl,
			final String grantType, final String clientId, final String userName, final String password) throws BadAuthResponseException {

		final Form form = new Form();
		form.param("username", userName);
		form.param("password", password);
		form.param("grant_type", grantType);
		form.param("client_id", clientId);

		final WebTarget target = client.target(authUrl);
		final Response response = target.request().accept(MediaType.APPLICATION_JSON_TYPE)
				.header("Content-Type", "application/x-www-form-urlencoded")
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
		try {
			if (response.getStatus() != 200) {
				throw new BadAuthResponseException(target.getUri(), response.getStatusInfo().getReasonPhrase(),
				        response.getStatus());
			}
			final String json = response.readEntity(String.class);
			try (final JsonReader reader = Json.createReader(new StringReader(json))) {
			    return reader.readObject().getJsonString("access_token").getString();
			}
		} finally {
			response.close();
		}
	}
}
