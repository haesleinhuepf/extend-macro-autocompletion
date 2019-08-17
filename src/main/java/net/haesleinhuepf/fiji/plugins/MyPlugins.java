package net.haesleinhuepf.fiji.plugins;

import net.haesleinhuepf.fiji.macro.MyMacroExtensionDescriptor;

/**
 * This class just holds a list of plugins.
 *
 * An alternative for doing this would be implementing a SciJava service providing all plugins as shown in the
 * plugin zoo:
 * https://github.com/mpicbg-scicomp/ij2course-scijava-plugin-mechanism/tree/solution
 *
 *
 * @author haesleinhuepf
 *         August 2019
 */
public interface MyPlugins {
    // macro extensions should have a prefix in order to prevent
    // conflicts between different extensions
    String macroExtensionPrefix = "MyLib_";

    // list of all available plugins
    MyMacroExtensionDescriptor[] list = {
            new MyPluginAdd(),
            new MyPluginMultiply()
    };
}
