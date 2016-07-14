$(function(){
	
	// load index
	(function(){
		$("#content").load($(".side-menu li a:first").attr("data-url"));
	})();
	
	// menu click 
	(function(){
		$(".side-menu li a").click(function(){
			var t = this;
			$("#content").load($(t).attr("data-url"));
			$(".side-menu li").each(function(){
				$(this).removeClass("active");
				$(t).parent().addClass("active");
				$(".logo").text($(t).find("span").text());
			});
		});
	})();
});