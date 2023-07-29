package com.jersey.rest.messanging.resource;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.jersey.rest.messanging.model.ParamBeanFilter;

@Path("inject")
public class InjectionJax {

	// to pass multiple matrix parameter
	// http://localhost:8080/messanging/webapi/inject/annonations;param=Deep;param2=Kumar
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	@Path("annotations")
//	public String getInjectionAnnotation(@MatrixParam("param") String matrixParam,
//			@HeaderParam("authSessionId") String authSessionId, @HeaderParam("baseURI") String baseURI,
//			@CookieParam("name") String name) {
//		return "Matrix Param=" + matrixParam + "  " + "Header Param Value=" + authSessionId + " " + "Base Uri="
//				+ baseURI + "  " + "Cookie Value=" + name;
//	}

	//

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("annotations")
	public String getInjectionAnnotation(@BeanParam ParamBeanFilter beanParam) {
		return "Matrix Param=" + beanParam.getMatrixParam() + "  " + "Header Param Value="
				+ beanParam.getAuthSessionId() + " " + "Base Uri=" + beanParam.getBaseURI() + "  " + "Cookie Value="
				+ beanParam.getName();
	}

	//

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("annotations2")
	public String getInjectionAnnotation2(@Context HttpHeaders header, @Context UriInfo info) {

		Map<String, List<String>> headers = header.getRequestHeaders();
		// System.out.println(headers);
		Collection<List<String>> list = headers.values();
		// info.getAbsolutePath().toString();
		return "All Header Value = " + " " + list + "      -------" + info.getAbsolutePath().toString();
	}

	//
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("login")
	public String login(@FormParam("userName") String userName) {

		return "Hello " + userName;
	}

}
