package ru.brazhnikov.launcher;

import java.net.URL;
import java.security.ProtectionDomain;
import java.util.EnumSet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;

/**
 * Launcher - класс для запуска приложения
 *
 * @version 1.0.1
 * @package ru.brazhnikov.launcher
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public class Launcher {

    /**
     * main
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        Server server = new Server(8189 );

        ProtectionDomain domain = Launcher.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath( "/" );
        webapp.setWar( location.toExternalForm() );
        webapp.addFilter(
                new FilterHolder( new DelegatingFilterProxy("springSecurityFilterChain" ) ),
                "/*", EnumSet.allOf( DispatcherType.class )
        );

        server.setHandler( webapp );

        try {
            server.start();
            server.join();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
