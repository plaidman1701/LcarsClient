# Client-side J2EE webapp calling RESTful service

This was inspired by a project I did for a J2EE class I took at BCIT. I love this kind of design because of the strict encapsulation; with a little work it can be expanded to include new functions but anything you want to add is basically "plug-and-play".

There are screenshots and collaboration diagrams in the labled folder, but basically the servlet accets a GET from the UserAgent and builds a datasource command using an abstracted class and interface, and sends the command to a REST endpoint provided by the accompanying Service webapp. Most responses from the service don't include the datastore's entity representation but just a serialized POJO of Strings for the client to disassemble and present.
