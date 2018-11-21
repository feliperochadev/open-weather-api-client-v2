package com.finleap.casestudy.feliperocha.openweatherapiclient.controller.v1

import com.finleap.casestudy.feliperocha.openweatherapiclient.controller.BaseControllerIntegrationTest
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class WeatherControllerIntegrationTest extends BaseControllerIntegrationTest {

    def 'test'() {
        given:
        def city = 'berlin'

        expect:
        mockMvc.perform(requestBuilder.buildGetRequest("/$city")).andDo(print()).andExpect(status().isOk())
    }
}
