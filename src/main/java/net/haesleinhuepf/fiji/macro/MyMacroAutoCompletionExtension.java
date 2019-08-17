package net.haesleinhuepf.fiji.macro;

import net.haesleinhuepf.fiji.plugins.MyPlugins;
import net.imagej.legacy.plugin.MacroExtensionAutoCompletionPlugin;
import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.scijava.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * MyMacroAutoCompletionExtension
 *
 * This class communicates with Fijis script editor. It hands over a list of potential commands
 * which appear in the auto-completion pulldown.
 *
 * Author haesleinhuepf
 *        August 2019
 */
@Plugin(type = MacroExtensionAutoCompletionPlugin.class)
public class MyMacroAutoCompletionExtension implements MacroExtensionAutoCompletionPlugin {
    @Override
    public List<BasicCompletion> getCompletions(CompletionProvider completionProvider) {
        ArrayList<BasicCompletion> completions = new ArrayList<BasicCompletion>();

        MyMacroExtensionDescriptor[] pluginList = MyPlugins.list;

        // go through plugins and provide an auto-complete entry for each
        for (MyMacroExtensionDescriptor plugin : pluginList) {
            String commandName = "Ext.MyLib_" + plugin.getClass().getSimpleName();
            completions.add(new BasicCompletion(completionProvider, commandName, null, plugin.description()));
        }



        return completions;
    }
}
