function createSwitch(buttonText){
	var t = $("#switchTemplate").html();
	t = t.replace(new RegExp("{{text}}", "g"), buttonText);
	$(t).appendTo("body");
}

$("document").ready(function(){
	createSwitch("Wash Face");
	createSwitch("Brush Teeths");
	
	var w = window.innerWidth;
	var h = window.innerHeight;
	$("window size" + w + ":" + h).appendTo("body");
	var player = $("#audioPlayer")[0];
	player.src = "01-second-flight.mp3";
	player.volume = 0.1
	player.play();
	//player.pause();
	player.currentTime = 0;
	console.log();
});
