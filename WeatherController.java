package com.dbs.weather.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import org.apache.logging.log4j.Level;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import io.vertx.core.Vertx;

@RestController
public class WeatherController {
//	@GetMapping("/getweather")
//	public Class[] getWeather() {
//		HttpURLConnection con;
//		URL url;
//		Class[] weather = null;
//		try {
//			System.setProperty("http.proxyHost", "127.0.0.1");
//			System.setProperty("http.proxyPort", "8080");
//			url = new URL("https://api.darksky.net/forecast/5e396b26190f82bef3354bfe38713bb0/42.3601,-71.0589");
//			con = (HttpURLConnection) url.openConnection();
//			con.setRequestMethod("GET");
//			con.setConnectTimeout(15000);
//			con.setReadTimeout(15000);
//			con.getContent(weather);
//			System.out.println("Data :"+con.getContent(weather));
//			return weather;
//		} catch (Exception e) {
//			System.out.println("Exception");
//			e.printStackTrace();
//		}
//		return null;
//	}
	@GetMapping("/get")
	public String main() {
		return "Greetings";
	}
	@GetMapping("/getdata")
// 	@RequestMapping(value = "/getdata", method = RequestMethod.GET, produces = "application/json")
	public String data() {
		String output = null;
		  try {
			  
			URL url = new URL("https://api.darksky.net/forecast/aae5edbb02f5660b506f6d7edbc218bd/42.3601,-71.0589");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
			conn.setRequestMethod("GET");
			
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		  return output;
		}
//	public void clientTest() {
////        Vertx vertx = Vertx.vertx();
//
//        WebClient client2 = WebClient.create("https://api.darksky.net/forecast/5e396b26190f82bef3354bfe38713bb0/42.3601,-71.0589");
//        client2.get();
//        String response2 = ((RequestHeadersSpec<?>) client2).exchange()
//        		  .block()
//        		  .bodyToMono(String.class)
//        		  .block();
//        System.out.println(response2);
//        
//	}
}
