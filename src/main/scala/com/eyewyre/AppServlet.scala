package com.eyewyre

import _root_.javax.servlet.ServletConfig
import _root_.com.vaadin.annotations.VaadinServletConfiguration
import _root_.com.vaadin.server.VaadinServlet
import _root_.javax.servlet.annotation.WebServlet

@WebServlet(value = Array("/*","/VAADIN/*"), asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = classOf[AppUI], widgetset = "com.eyewyre.AppWidgetSet")
class AppServlet extends VaadinServlet {
  override def init(servletConfig: ServletConfig) {
    super.init(servletConfig)
  }
}
