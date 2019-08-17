// Macro extensions example macro
//
// This macro shows how extend macro with custom
// functions which are also auto-completed.
//
// Author: Robert Haase
//         August 2019
// ---------------------------------------------

run("Close All");

// Get test data
run("Blobs (25K)");
getDimensions(width, height, channels, slices, frames)

run("My Macro Extensions", "");
Ext.MyLib_MyPluginAdd(getTitle(), 5);



