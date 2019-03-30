package k2works.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/echo")
public class EchoController {

    private static final Logger LOG = LoggerFactory.getLogger(EchoController.class);

    @ApiOperation(value = "POSTしたメッセージをそのまま返答するAPI")
    @RequestMapping(method = RequestMethod.POST)
    public String loadSession(@RequestParam("message") String message) {
        LOG.info("receive message: " + message);
        return message;
    }

}