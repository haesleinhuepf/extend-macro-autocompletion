package net.haesleinhuepf.fiji.macro;

import ij.macro.Functions;
import ij.macro.ExtensionDescriptor;
import ij.macro.MacroExtension;
import net.haesleinhuepf.fiji.plugins.MyPlugins;
import org.scijava.command.Command;
import org.scijava.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * MyMacroExtensions
 *
 * This class communicates with ImageJs macro interpreter. It hands over a list of commands
 * (of type ExtensionDescriptor) to the macro interpreter which will be accepted as valid
 * commands. Furthermore, it's called when one of the commands is executed.
 *
 *
 * @author haesleinhuepf
 *         August 2019
 */
@Plugin(type = Command.class, menuPath = "Plugins>My Macro Extensions")
public class MyMacroExtensions implements MacroExtension, Command {
    @Override
    public String handleExtension(String name, Object[] args) {
        MyMacroExtensionDescriptor[] pluginList = MyPlugins.list;

        // go through plugin list an check if we know the called plugin
        for (MyMacroExtensionDescriptor plugin : pluginList) {
            String command = MyPlugins.macroExtensionPrefix + plugin.getClass().getSimpleName();

            // if name matches exactly
            if (command.compareTo(name) == 0) {
                // call the plugin
                plugin.runFromMacro(args);
                break;
            }
        }
        return null;
    }

    @Override
    public ExtensionDescriptor[] getExtensionFunctions() {
        MyMacroExtensionDescriptor[] pluginList = MyPlugins.list;

        ExtensionDescriptor[] result = new ExtensionDescriptor[pluginList.length];

        int i = 0;
        // formulate a list of ExtensionDescriptors describing all command this class can handle
        for (MyMacroExtensionDescriptor plugin : pluginList) {
            String call = MyPlugins.macroExtensionPrefix + plugin.getClass().getSimpleName();
            result[i] = new ExtensionDescriptor(call, plugin.parameterTypes(), this);
            i++;
        }

        // hand over the list to ImageJs macro interpreter
        return result;
    }

    @Override
    public void run() {
        // Activate this class as handler for macro extensions
        Functions.registerExtensions(this);
    }
}
