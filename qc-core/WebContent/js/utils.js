(function(){
	var utils = {
		/*设置cookie*/
		setCookie : function(key, value, expire) {
		    var date = new Date();
		    date.setTime(date.getTime() + expire);
		    document.cookie = key + "=" + escape(value) + ";expires=" + date.toGMTString();
		    return true;
		},
		/*获取cookie*/
		getCookie : function (key) {
			if (document.cookie.length > 0) {
				start = document.cookie.indexOf(key + "=");
				if (start != -1) {
					start = start + key.length + 1;
					end = document.cookie.indexOf(";", start);
					if (end == -1) {
						end = document.cookie.length;
					}
					return unescape(document.cookie.substring(start, end))
				}
			}
			return null;
		},
		/*设置LocalStorage*/
		setLocalStorage : function(key, value) {
		    if (window.localStorage) {
		        window.localStorage.setItem(key, value);
		        return true;
		    }
		    return false;
		},
		/*获取LocalStorage*/
		getLocalStorage : function (key){
			if(window.localStorage){
				return window.localStorage.getItem(key);
			}
			return null;
		}
	};
	// 暴露到外面
	window.utils = utils;
}());