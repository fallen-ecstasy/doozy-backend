package com.doozy.streamingservice.Controller;


import com.doozy.streamingservice.Entity.StreamChunk;
import com.doozy.streamingservice.Service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreamController {

//            - `/api/audiobooks`
//            - `/api/audiobooks/:id`
//            - `/api/audiobooks/:id/chapters`
//            - `/api/audiobooks/:id/reviews`
//            - `/api/audiobooks/:id/reviews/add`

    @Autowired
    StreamingService streamingService;

    @GetMapping("/stream/hello")
    public String helloWorld(){
        return "HELLO WORLD! SERVER RUNNING !";
    }

    @GetMapping("/stream/{fileName}")
    public ResponseEntity<byte[]> streamVideo(@RequestHeader(value = "Range", required = false) String httpRangeList,
                                                    @PathVariable("fileName") String fileName) {
        return streamingService.prepareContent(fileName, httpRangeList);
    }


}
