package com.bmc.truesight.pulse.plugin;

import com.boundary.plugin.sdk.PluginRunner;
import com.boundary.plugin.sdk.jmx.JMXPlugin;

public class JVM extends JMXPlugin {

    public static void main(String[] args) {
        
        PluginRunner plugin = new PluginRunner(JVM.class.getName());                
        plugin.run();
    }

}
