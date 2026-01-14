package com.snipper.springDemoApplication.Controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
public class ScopeBeanController {

}
