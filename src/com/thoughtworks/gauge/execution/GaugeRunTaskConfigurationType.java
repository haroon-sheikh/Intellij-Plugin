package com.thoughtworks.gauge.execution;

import com.intellij.execution.configuration.ConfigurationFactoryEx;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.extensions.Extensions;
import com.intellij.openapi.project.Project;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class GaugeRunTaskConfigurationType extends ConfigurationTypeBase {
    public GaugeRunTaskConfigurationType() {
        super("executeSpecs", "Gauge Execution", "Execute the gauge tests", AllIcons.Actions.Execute);
        final ConfigurationFactory scenarioConfigFactory = new ConfigurationFactoryEx(this) {
            @Override
            public RunConfiguration createTemplateConfiguration(Project project) {
                return new GaugeRunConfiguration("Gauge Execution", project, this);
            }
        };

        addFactory(scenarioConfigFactory);
    }


    public GaugeRunTaskConfigurationType getInstance() {
        return ContainerUtil.findInstance(Extensions.getExtensions(CONFIGURATION_TYPE_EP), GaugeRunTaskConfigurationType.class);
    }
}
