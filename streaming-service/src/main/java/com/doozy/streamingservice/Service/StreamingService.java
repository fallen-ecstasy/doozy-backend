package com.doozy.streamingservice.Service;

import org.springframework.http.ResponseEntity;

public interface StreamingService {
    ResponseEntity<byte[]> prepareContent(String fileName, String httpRangeList);
}
