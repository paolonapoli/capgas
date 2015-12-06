package it.cs.capgas.web.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private @Value("${test.param1}") String sysprop;

    public String getName() {
	return "date " + System.nanoTime() + "  [SYSPROP = " + sysprop + "]";
    }
}
