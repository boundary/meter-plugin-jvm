package com.bmc.truesight.pulse.plugin;

import com.boundary.plugin.sdk.PluginJSON;
import com.boundary.plugin.sdk.PluginRunner;
import com.boundary.plugin.sdk.jmx.JMXPlugin;
import com.boundary.plugin.sdk.jmx.JMXPluginConfiguration;
import com.boundary.plugin.sdk.jmx.MBeanEntry;
import com.boundary.plugin.sdk.jmx.MBeanMap;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

public class JVM extends JMXPlugin {

    public static void main(String[] args) {
        
        PluginRunner plugin = new PluginRunner(JVM.class.getName());                
        plugin.run();
    }

}
