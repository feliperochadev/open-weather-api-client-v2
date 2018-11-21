package com.finleap.casestudy.feliperocha.openweatherapiclient.controller


import com.github.tomakehurst.wiremock.WireMockServer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.support.DirtiesContextTestExecutionListener
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

@SpringBootTest
@WebAppConfiguration
@TestExecutionListeners([DependencyInjectionTestExecutionListener, DirtiesContextTestExecutionListener])
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class BaseControllerIntegrationTest extends Specification {

    @Autowired
    protected RequestBuilder requestBuilder

    @Autowired
    private WebApplicationContext wac

    protected MockMvc mockMvc

    WireMockServer wireMockServer = new WireMockServer(8080)

    def setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build()
        wireMockServer.start()
    }

    def cleanup() {
        wireMockServer.stop()
    }
}
