package com.Mentorship_app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Mentorship_app.Entity.Connection;
import com.Mentorship_app.Entity.ConnectionRequest;
import com.Mentorship_app.Entity.ConnectionRequestDTO;
import com.Mentorship_app.services.ConnectionRequestService;
import com.Mentorship_app.services.ConnectionService;


@RestController
@CrossOrigin("https://extraordinary-cendol-db85f2.netlify.app/")
public class ConnectionController {
    @Autowired
    private ConnectionRequestService connectionRequestService;
    @Autowired
    private ConnectionService ConnectionService;
    

    @PostMapping("/send-connection-request")
    public ResponseEntity<ConnectionRequest> sendConnectionRequest(
        @RequestBody Map<String, String> payload
    ) {
        String senderEmail = payload.get("senderEmail");
        String receiverEmail = payload.get("receiverEmail");
        
        ConnectionRequest request = connectionRequestService
            .sendConnectionRequest(senderEmail, receiverEmail);
        
        return ResponseEntity.ok(request);
    }

    @PostMapping("/handle-connection-request")
    public ResponseEntity<ConnectionRequest> handleConnectionRequest(
        @RequestBody Map<String, String> payload,@RequestBody ConnectionRequestDTO requestDTO
    ) {
        Long requestId = Long.parseLong(payload.get("requestId"));
        String status = payload.get("status");
        ConnectionRequest request = connectionRequestService
            .handleConnectionRequest(requestId, status);
        return ResponseEntity.ok(request);
    }

    @GetMapping("/connection-requests/{email}")
    public ResponseEntity<List<ConnectionRequest>> getConnectionRequests(
        @PathVariable String email
    ) {
        List<ConnectionRequest> requests = connectionRequestService
            .getConnectionRequests(email);
        
        return ResponseEntity.ok(requests);
    }
    @GetMapping("/accepted-connections/{email}")
    public List<Connection> getAcceptedConnections(@PathVariable String email) {
        return ConnectionService.getAcceptedConnections(email);
    }}