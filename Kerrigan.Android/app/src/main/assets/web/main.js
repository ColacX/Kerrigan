function appendSwitch(buttonText){
	var t = $("#switchTemplate").html();
	t = t.replace(new RegExp("{{text}}", "g"), buttonText);
	$(t).appendTo("body");
}

function startAlarm(){
	var player = $("#audioPlayer")[0];
	player.src = "01-second-flight.mp3";
	player.volume = 0.1
	player.play();
}

function stopAlarm(){
	var player = $("#audioPlayer")[0];
	player.pause();
}

$("document").ready(function(){
	appendSwitch("Wash Face");
	appendSwitch("Brush Teeths");
	appendSwitch("Shave");
	appendSwitch("Fix Hair");
	appendSwitch("Make Bed");
	
	var w = window.innerWidth;
	var h = window.innerHeight;
	$("<span>window size" + w + ":" + h + "</span>").appendTo("body");
});
