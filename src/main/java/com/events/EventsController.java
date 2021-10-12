package com.events;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventsController {

	
		@RequestMapping(value = "/events", method = RequestMethod.GET)
		public String showTodosList() {
			return "events";
		}
}
