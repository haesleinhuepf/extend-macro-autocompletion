package net.haesleinhuepf.fiji.plugins;


import ij.ImagePlus;
import ij.WindowManager;
import ij.macro.MacroExtension;
import net.haesleinhuepf.fiji.macro.MyMacroExtensionDescriptor;
import org.scijava.command.Command;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

/**
 * A fancy plugin which adds a given number to all pixels of an image.
 *
 * @author haesleinhuepf
 *         August 2019
 */
@Plugin(type = Command.class, menuPath = "Plugins>My Plugin Add")
public class MyPluginAdd implements Command, MyMacroExtensionDescriptor {
    /**
     * This is the actual algorithm. It adds a number to any pixel of the image
     *
     * @param imp input image
     * @param scalar number to add
     */
    private void actualAlgorithm(ImagePlus imp, double scalar) {
        imp.getProcessor().add(scalar);
    }

    // --------------------------------------------------------------------------------------
    // these are implementations allowing MyMacroExtensions building autocompletion and
    // calling the right command

    // called by MyMacroExtensions in case the command is called from macro
    @Override
    public void runFromMacro(Object[] parameters) {
        // We get an array of objects from the Macro interpeter.
        // We need to convert/cast it to what we need
        ImagePlus imp = WindowManager.getImage((String)parameters[0]);
        double scalar = (Double)parameters[1];

        // call the actual algorithm
        actualAlgorithm(imp, scalar);
    }

    /**
     * We need to define a list of parameter types
     * @return int arry with parameter types as defined in the MacroExtension class.
     */
    @Override
    public int[] parameterTypes() {
        return new int[] {MacroExtension.ARG_STRING, MacroExtension.ARG_NUMBER};
    }

    /**
     * We should provide a user readable list of parameters
     * @return list of parameters
     */
    @Override
    public String parameters() {
        return "imageTitle, number";
    }

    /**
     * We should define a description for users.
     * @return algorithm/parameter description
     */
    @Override
    public String description() {
        return "<b>Hey folks</b>, just enter an image and a number.The number will then be added to all pixels.<br><br>" +
                "Oh and visit my website or follow me on twitter :-)<br>" +
                "<a href=\"http://haesleinhuepf.net/\">haesleinhuepf.net</a><br>" +
                "<a href=\"https://twitter.com/haesleinhuepf/\">twitter.com/haesleinhuepf</a><br>";
    }


    // --------------------------------------------------------------------------------------
    // This is the definition of parameters to allow SciJava building a
    // dialog for us in case the user clicks the menu
    @Parameter
    ImagePlus input;

    @Parameter
    Double scalar;

    // called by SciJava on menu click
    @Override
    public void run() {
        actualAlgorithm(input, scalar);
    }
}
