package com.example.productsdemo.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import static com.example.productsdemo.Consts.Globals.GLOBAL_FRONTEND_URL;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = GLOBAL_FRONTEND_URL)
public class ProductController {
}
