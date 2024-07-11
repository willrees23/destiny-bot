package dev.wand.listener;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ShutdownEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import spark.Spark;

public class ShutdownListener implements EventListener {
    @Override
    public void onEvent(GenericEvent event) {
        if (event instanceof ShutdownEvent) {
            System.out.println("Shutting down...");
            Spark.stop();
        }
    }
}
