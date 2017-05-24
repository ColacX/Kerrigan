$("document").ready(function(){
	var w = window.innerWidth;
	var h = window.innerHeight;
	$("window size" + w + ":" + h).appendTo("body");
	var player = $("#audioPlayer")[0];
	player.src = "01-second-flight.mp3";
	player.volume = 0.1
	player.play();
	player.pause();
	sound.currentTime = 0;
	console.log();
});
