package com.github.x3n0r.sportbet.services;

import java.net.HttpURLConnection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.x3n0r.sportbet.dao.TournamentDAO;

@Path("/tournament")
public class TournamentService extends Service {

	@Path("all")
	@GET 
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllTournaments() {
		try (TournamentDAO dao = new TournamentDAO()) {
			return buildOkResponse(dao.getAllTournaments());
		} catch (Exception e) {
			return buildErrorResponse(HttpURLConnection.HTTP_BAD_REQUEST, e.getMessage());
		}
	}
	
}
