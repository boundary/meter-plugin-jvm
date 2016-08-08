package com.bmc.truesight.pulse.plugin;


import com.boundary.plugin.sdk.MetricDefinition;
import com.boundary.plugin.sdk.jmx.JMXPlugin;
import com.boundary.plugin.sdk.jmx.MBeanEntry;
import com.boundary.plugin.sdk.jmx.MBeanMap;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;


public class MBeansConfigTests {

    private final int MBEAN_COUNT = 76;
    private final String METRICS_FILENAME = "metrics.json";

    public Map<String, MetricDefinition> loadMetrics() throws Exception {
        BufferedReader json = new BufferedReader(new FileReader(METRICS_FILENAME));
        Gson gson = new Gson();
        Type stringMBeanEntryMap = new TypeToken<Map<String, MBeanEntry>>() {}.getType();
        Map<String, MetricDefinition> metrics = gson.fromJson(json, stringMBeanEntryMap);
        return metrics;
    }

    @Test
    public void testMetricsLoad() throws Exception {
        BufferedReader json = new BufferedReader(new FileReader(METRICS_FILENAME));
        Gson gson = new Gson();
        Type stringMBeanEntryMap = new TypeToken<Map<String, MBeanEntry>>() {}.getType();
        Map<String, MetricDefinition> metrics = gson.fromJson(json, stringMBeanEntryMap);

        assertThat(metrics.size(), is(equalTo(MBEAN_COUNT)));
    }

    @Test
    public void testMBeanLoad() {
        JMXPlugin plugin = new JMXPlugin();
        plugin.loadMBeanConfiguration();
        MBeanMap mbeanMap = plugin.getMbeanMap();
        ArrayList<MBeanEntry> mbeans = mbeanMap.getMap();

        assertThat(mbeans.size(), is(equalTo(MBEAN_COUNT)));
    }


    @Test
    public void testCheckForMissingMBeans() throws Exception {

    }

    @Test
    public void testCheckForMissingMetrics() throws Exception {
        Map<String, MetricDefinition> metrics = loadMetrics();


        for (Map.Entry<String, MetricDefinition> entry : metrics.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}