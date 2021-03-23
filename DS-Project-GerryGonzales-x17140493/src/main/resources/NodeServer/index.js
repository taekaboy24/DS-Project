var grpc = require("grpc");
var events = require("events");
// add the bookStream global variable
var camStream = new events.EventEmitter();
var camProto = grpc.load("Securitycamera.proto");
var camAppliance = {
    aname: "SecurityCam",
    status: "On",
    cam: "No Cam Selected",
    volume: 30
};
var server = new grpc.Server();
server.bind("0.0.0.0:1237", grpc.ServerCredentials.createInsecure());
console.log("Server running at http://0.0.0.0:1237");

server.addService(camProto.org.DS.gerryproject.SmartFarmingGRPC.SecuritycameraService.service, {
    initialAppliance: function (call, callback) {
        callback(null, camAppliance);
    },
    changeCamera: function (call, callback) {
        var camName = call.request.text;
        if (camName == "Select a Camera") {
            camAppliance.cam = "No Camera On";
        } 
        else {
            camName.cam = camName
        }

        return callback(null, camAppliance.cam);
    },

    changeVolume: function (call, callback) {
        var requestVolume = call.request.length;
        var newVolume = camAppliance.volume + requestVolume
        if (newVolume < 100 && newVolume >= 0) {
            camAppliance.volume = newVolume;
        }
        console.log(camAppliance);
        return callback(null, camAppliance.volume);
    },
    onOff: function (call, callback) {
        var requestValue = call.request.msg
        console.log(requestValue)
        if (requestValue == true) {
            camAppliance.status = "On"
        } 
        else {
            camAppliance.status = "Off"
        }
        var response;
        if (camAppliance.status == "On") {
            response = true;
        } 
        else {
            response = false;
        }
        callback(null, resp);
    },
    changeApplianceName: function (call, callback) {
        var requestName = call.request.text
        camAppliance.aname = requestName
        console.log("Name" + camAppliance.aname);

        callback(null, camAppliance.aname);
    }
});

server.start();