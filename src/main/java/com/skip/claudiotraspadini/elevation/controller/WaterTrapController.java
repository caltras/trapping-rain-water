package com.skip.claudiotraspadini.elevation.controller;

import com.skip.claudiotraspadini.elevation.service.WaterTrapService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Path("/water-trap")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WaterTrapController {

    @Inject
    WaterTrapService waterTrapService;

    @POST
    @Operation(summary = "Calculate trapped water volume", 
        description = "Calculates the total volume of water that can be trapped given an elevation map.")
    @APIResponse(
        responseCode = "200",
        description = "The total trapped water volume.",
        content = @Content(schema = @Schema(implementation = Integer.class))
    )
    public Response calculateTrappedWater(
            @RequestBody(description = "Array representing the elevation map", required = true,
                content = @Content(schema = @Schema(implementation = int[].class)))
            int[] height) {
        int volume = waterTrapService.totalVolume(height);
        return Response.ok(volume).build();
    }
} 