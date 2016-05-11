var Util = Util || {};
Util.config = {
	CITYSPOTLIGHT : [],
	HOTCITYSPOTLIGHT : [],
	BANKSSPOTLIGHT : []
};
Util.safeRange = function(obj) {
	if (typeof (obj) === "string") {
		b = Util.getID(obj);
	} else {
		b = obj;
	}
	var c, d, e, f, g, h, j, k;
	j = b.offsetWidth;
	k = b.offsetHeight;
	p = Util.pageSize();
	c = 0;
	e = p.clientWidth - j;
	g = e / 2;
	d = 0;
	f = p.clientHeight - k;
	var hc = p.clientHeight * 0.382 - k / 2;
	h = (k < p.clientHeight / 2) ? hc : f / 2;
	if (g < 0)
		g = 0;
	if (h < 0)
		h = 0;
	return {
		width : j,
		height : k,
		minX : c,
		minY : d,
		maxX : e,
		maxY : f,
		centerX : g,
		centerY : h
	};
};
Util.getPosition = function(obj) {
	if (typeof (obj) === "string")
		obj = Util.getID(obj);
	var c = 0;
	var d = 0;
	var w = obj.offsetWidth;
	var h = obj.offsetHeight;
	do {
		d += obj.offsetTop || 0;
		c += obj.offsetLeft || 0;
		obj = obj.offsetParent;
	} while (obj)
	return {
		x : c,
		y : d,
		width : w,
		height : h
	};
};
Util.clSelect = function() {
	try {
		window.getSelection ? window.getSelection().removeAllRanges()
				: document.selection.empty();
	} catch (_) {
	}
};
Util.pageSize = function() {
	var a = Util.Browser.isStrict ? document.documentElement : document.body;
	var b = [ "clientWidth", "clientHeight", "scrollWidth", "scrollHeight" ];
	var c = {};
	for ( var d in b)
		c[b[d]] = a[b[d]];
	c.scrollLeft = document.body.scrollLeft
			|| document.documentElement.scrollLeft;
	c.scrollTop = document.body.scrollTop || document.documentElement.scrollTop;
	return c;
};
Util.getID = function(id) {
	return document.getElementById(id);
};
Util.Model = function(items, inparams) {
	var params = {
		title : '',
		type : '',
		maskerID : 'modelOverlay',
		contentID : 'modelContent',
		className : '',
		width : 550,
		height : '',
		top : '',
		alpha : 0.35,
		bgColor : '#000',
		time : '',
		onSelect : '',
		noSelect : '',
		divId : false,
		isDrag : true,
		btns : true,
		nbtnShow : true,
		dbclick : true,
		keydown : true,
		mZindex : 9997,
		cZindex : 9999,
		ybtn : '确定',
		nbtn : '取消',
		yClass : '',
		nClass : '',
		closeTxt : '关闭'
	};
	if (inparams && typeof (inparams) == 'object') {
		for ( var key in inparams) {
			if (key.match(/^_/)) {
				continue;
			}
			params[key] = inparams[key];
		}
	}
	;
	Util.config.modelFn = params.noSelect;
	var _width = Util.pageSize()['scrollWidth'];
	var _height = Util.pageSize()['scrollHeight'];
	$(window).size(function() {
		_width = Util.pageSize()['scrollWidth'];
		_height = Util.pageSize()['scrollHeight'];
	});
	var html = '<div id="'
			+ params.maskerID
			+ '" style="position:absolute;left:0;top:0;right:0;bottom:0;z-index:'
			+ params.mZindex + ';width:' + _width + 'px;height:' + _height
			+ 'px;background:' + params.bgColor + '"></div>';
	html += '<div id="' + params.contentID + '" class="model-dialog '
			+ params.className + '" style="z-index:' + params.cZindex
			+ ';width:' + params.width + 'px;height:' + params.height + 'px">';
	html += '<div class="model-head">';
	html += '<h2>' + params.title + '</h2>';
	html += '<a href="javascript:;" class="btn r3 model-close"><i class="icons">'
			+ params.closeTxt + '</i></a>';
	html += '</div>';
	html += '<div class="dialog-body">';
	if(params.divId) {
		html +=  $('#' + params.divId).html();
		$('#' + params.divId).html('');
	} else {
		html += items;
	}
	html += '</div>';
	if (params.btns) {
		html += '<div class="model-foot"><div class="inner">';
		if (params.nbtnShow) {
			html += '<a href="javascript:;" class="model-close '
					+ params.nClass + '"><i class="icons yclose"></i>'
					+ params.nbtn + '</a>';
		}
		;
		html += '<a href="javascript:;" class="model-yes '
				+ params.yClass + '"><i class="icons cm-white"></i>'
				+ params.ybtn + '</a>';
		html += '</div></div>';
	}
	html += '</div>';
	$(html).appendTo('body').fadeIn(200);
	var modelBox = $('#' + params.maskerID);
	var modelBody = $('#' + params.contentID);
	modelBox.fadeTo(0, params.alpha);
	var tmpH = modelBody.height();
	var tmpW = modelBody.width();
	var tmpL = ($(window).width() - tmpW) / 2;
	var tmpT = ($(window).height() - tmpH) / 2 + $(document).scrollTop();
	modelBody.css({
		left : tmpL,
		top : params.top == '' ? tmpT : params.top,
		width : tmpW
	}).fadeIn(200);
	if (typeof params.time === 'number') {
		setTimeout(function() {
			Util.modelClose(modelBox, modelBody,params.divId);
		}, params.time);
	}
	if (params.isDrag) {
		Util.drag({
			obj : params.contentID,
			handle : '.model-head'
		});
	}
	;
	modelBody.find('.model-yes').click(function() {
		if (params.onSelect != '' && $.isFunction(params.onSelect)) {
			params.onSelect(this,modelBox,modelBody,params.divId);
		}
	});
	modelBody.find('.model-close').click(function() {
		if (params.noSelect != '' && $.isFunction(params.noSelect)) {
			params.noSelect(this,modelBox,modelBody,params.divId);
		} else {
			Util.modelClose(modelBox, modelBody,params.divId);
		}
		return false;
	});
	if (params.dbclick) {
		modelBox.bind('dblclick', function(e) {
			e = e || window.event;
			var ele = e.srcElement ? e.srcElement : e.target;
			Util.modelClose(modelBox, modelBody,params.divId);
		});
	}
	if (params.keydown) {
		document.onkeydown = function(event) {
			event = window.event || event;
			var keyCode = event.keyCode || event.which || event.charCode;
			if (event.keyCode == 27) {
				Util.modelClose(modelBox, modelBody,params.divId);
			} else if (event.keyCode == 13) {
				return false;
			}
		};
	}
};
Util.modelClose = function(o, m,divId) {
	if(divId) {
		$('#'+divId).html(m.find('.dialog-body').html());
	}
	if (Util.config.modelFn != '' && $.isFunction(Util.config.modelFn)) {
		Util.config.modelFn(this);
	}
	o.fadeOut(function() {
		o.remove();
	});
	m.fadeOut(function() {
		m.remove();
	});
};

Util.alertClose = function(o,m,url) {
	o.fadeOut(function() {
		o.remove();
	});
	m.fadeOut(function() {
		m.remove();
	});
	if(url != '') {
		if(url == "reload") {
			window.location.reload();
		} else {
			window.location.href = url;
		}
	}
};

Util.jDialog = {
	Mask : function(dia, confirmCallback, cancelCallback) {
		if (typeof ($('#overlayModal')[0]) == 'undefined') {
			$('body').append('<div id="overlayModal"></div>');
			var mod = $('#overlayModal');
			var tmpWidth = $(document.body).width();
			var tmpHeight = $(document.body).height();
			if (Util.Browser.isios || Util.Browser.isAndroid) {
				tmpWidth = tmpWidth + 20;
			}
			;
			mod.css({
				position : 'absolute',
				left : 0,
				top : 0,
				right : 0,
				bottom : 0,
				width : tmpWidth,
				height : tmpHeight,
				background : '#000000',
				zIndex : 9997
			}).fadeTo(0, 0.3);
			Util.jDialog.Event(dia, mod, confirmCallback, cancelCallback);
		}
	}, 
	Event : function(dia, mod, confirmCallback, cancelCallback) {
		dia.find('.closeModal').click(function() {
			dia.fadeOut();
			mod.fadeOut(function() {
				mod.remove();
			});
			if (cancelCallback != false)
				cancelCallback();
			return
		});
		dia.find('.verifyModal').click(function() {
			dia.fadeOut();
			mod.fadeOut(function() {
				mod.remove();
			});
			if (confirmCallback != false)
				confirmCallback();
			return
		});
		document.onkeydown = function(event) {
			event = window.event || event;
			var keyCode = event.keyCode || event.which || event.charCode;
			if (event.keyCode == 27) {
				dia.fadeOut();
				mod.fadeOut(function() {
					mod.remove();
				});
				if (cancelCallback != false)
					cancelCallback();
				return
			}
		};
	},
	Pois : function(dia) {
		var tmpH = dia.height();
		var tmpW = dia.width();
		var tmpL = ($(window).width() - tmpW) / 2;
		var tmpT = ($(window).height() - tmpH) / 2 + $(document).scrollTop();
		dia.css({
			left : tmpL,
			top : tmpT,
			width : tmpW,
			zIndex : 9999
		}).fadeIn(200);
	},
	Modal : function(jdia, undia) {
		var dia = $('#' + jdia);
		if (Util.getID(jdia) && Util.getID(undia)) {
			Util.jDialog.Mask(dia, false, false);
			Util.jDialog.Pois(dia);
			Util.mDrag(jdia, undia);
		}
	},
	Prompt : function(options) {
		var defaults = {
			button : true,
			buttonCancel : true,
			icon : 'icons_info_alert',
			title : '提示',
			text : '',
			color : '#475058',
			closed : '关闭',
			cancel : '取消',
			confir : '确定',
			type : 'prompt',
			width : 400,
			confirmCallback : false,
			cancelCallback : false
		};
		if (options && typeof (options) == 'object') {
			for ( var key in options) {
				if (key.match(/^_/)) {
					continue;
				}
				defaults[key] = options[key];
			}
		}
		$('#dialogPrompt').remove();
		var html = '<div id="dialogPrompt" class="dialog-main" style="width:'
				+ defaults.width + 'px">';
		html += '<div class="dialog-head"><h2>'
				+ defaults.title
				+ '</h2><a href="javascript:;" class="closeModal r3"><i class="icons">'
				+ defaults.closed + '</i></a></div>';
		html += '<div id="dialogCont">';
		if (defaults.type == 'prompt') {
			html += '<div style="position:relative;height:40px;line-height:20px;text-align:left;padding:30px 20px 20px 120px; overflow:hidden">';
			html += '<table style="width:100%"><tr><td style="height:24px;color:'
					+ defaults.color
					+ '">'
					+ defaults.text
					+ '</td></tr></table>';
			html += '<i class="icons '
					+ defaults.icon
					+ '" style="position:absolute; left:50px; top:50%; margin-top:-30px"></i>';
			html += '</div>';
		}
		if (defaults.type == 'modal') {
			html += defaults.text;
		}
		if (defaults.button) {
			html += '<div class="dialog-foot"><div class="bank-action">';
			if (defaults.buttonCancel) {
				html += '<a href="javascript:;" class="r3 bank-delete closeModal"><i class="icons yclose"></i>'
						+ defaults.cancel + '</a>';
			}
			html += '<a href="javascript:;" class="r3 bank-bind verifyModal"><i class="icons cm-white"></i>'
					+ defaults.confir + '</a>';
			html += '</div></div>';
		}
		html += '</div></div>';
		$('body').append(html);
		var dia = $('#dialogPrompt');
		var mod = $('#overlayModal');
		Util.jDialog.Mask(dia, defaults.confirmCallback,defaults.cancelCallback);
		Util.jDialog.Pois(dia);
		Util.mDrag('dialogPrompt', 'dialogCont');
	},
	Alert : function(options) {
		var defaults_ = {
			icon : 'icons_info_alert',
			title : '提示',
			text : '',
			closed : '关闭',
			time : '',
			color : '#475058',
			url : '',
			width : 400
		};
		if (options && typeof (options) == 'object') {
			for ( var key in options) {
				if (key.match(/^_/)) {
					continue;
				}
				defaults_[key] = options[key];
			}
		}
		$('#dialogAlert').remove();
		var _width = Util.pageSize()['scrollWidth'];
		var _height = Util.pageSize()['scrollHeight'];
		$(window).size(function() {
			_width = Util.pageSize()['scrollWidth'];
			_height = Util.pageSize()['scrollHeight'];
		});
		var html = '<div id="overlayAlert" style="position:absolute;left:0;top:0;right:0;bottom:0;z-index:9997;width:' + _width + 'px;height:' + _height
			+ 'px;background:#000"></div>';
		
		
		html += '<div id="dialogAlert" class="alert-main" style="width:'
				+ defaults_.width + 'px">';
		html += '<div class="alert-head"><h2>'
				+ defaults_.title
				+ '</h2><a href="javascript:;" class="alert-close"><i class="icons">'
				+ defaults_.closed + '</i></a></div>';
		html += '<div id="alertCont">';

		html += '<div style="position:relative;height:40px;line-height:20px;text-align:left;padding:30px 30px 20px 120px; overflow:hidden">';
		html += '<table style="width:100%"><tr><td style="height:24px;color:'
				+ defaults_.color
				+ '">'
				+ defaults_.text
				+ '</td></tr></table>';
		html += '<i class="icons '
				+ defaults_.icon
				+ '" style="position:absolute; left:50px; top:50%; margin-top:-30px"></i>';
		html += '</div>';
		html += '</div>';
		
		
		
		html += '</div>';
		$('body').append(html);
		var modelBox = $('#overlayAlert');
		modelBox.fadeTo(0, 0.35);
		var dia = $('#dialogAlert');
		if (typeof defaults_.time === 'number') {
			setTimeout(function() {
				Util.alertClose(dia,modelBox,defaults_.url);
			}, defaults_.time);
		}
		Util.jDialog.Pois(dia);
		Util.mDrag('dialogAlert', 'alertCont');
		dia.find('.alert-close').click(function() {
			Util.alertClose(dia,modelBox,defaults_.url);
			return false;
		});
	},
	getPois : function(a, b) {
		this._b = null;
		if (b === null || b === '' || typeof b === 'undefined') {
			return a.width();
		} else {
			return b;
		}
		;
		this._b = b;
	}
};



Util.alert = function(title,text,types) {
	var option = {
		text:text,
		button:false,
		buttonCancel:false,
		icon : "icons_"+types+"_alert",
		title : title
	};
	Util.jDialog.Prompt(option);
};


Util.confirm = function(title,text,confirmCallback) {
	var option = {
		title : title,
        text : text,
        confirmCallback: confirmCallback,
        cancelCallback: function(){}
    };
	Util.jDialog.Prompt(option);
};
Util.confirm = function(title,text,confirmCallback,cancelCallback) {
	var option = {
		title : title,
        text : text,
        confirmCallback: confirmCallback,
        cancelCallback: cancelCallback
    };
	Util.jDialog.Prompt(option);
};


Util.drag = function(o) {
	var defaults = {
		obj : "",
		handle : "",
		lock : true,
		lockX : false,
		lockY : false,
		fixed : false,
		parent : "",
		temp : "",
		dstar : function() {
		},
		dmove : function() {
		},
		dstop : function() {
		}
	};
	var o = $.extend(defaults, o);
	var _x, _y, _d, safe, otemp, mx = my = 0, _this = $("#" + o.obj);
	Util.config.drag = true;
	_d = o.handle != "" ? $(o.handle, _this) : _this;
	_d.mousedown(function(ev) {
		if (!Util.config.drag)
			return;
		safe = Util.safeRange(o.obj);
		var tempBox = _this.parent().find(o.temp);
		s = Util.pageSize();
		otemp = o.temp != "" ? tempBox : _this;
		star(ev);
		if (o.obj.setCapture) {
			o.obj.setCapture();
		} else if (window.captureEvents) {
			window.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP);
		}
		;
		$(document).on("mousemove", function(e) {
			move(e);
		}).on("mouseup", function(e) {
			stop(e);
		});
	});
	if (o.fixed)
		o.parent = "";
	if (o.parent != "")
		$("#" + o.parent).css("position", "relative");
	var star = function(ev) {
		ev = ev || window.event;
		ev.preventDefault();
		p = Util.getPosition(o.obj);
		ny = o.fixed ? Util.Browser.isIE6 ? s.scrollTop : 0 : 0;
		mx = ev.clientX - p.x;
		my = ev.clientY - p.y + ny;
		if (o.temp != "") {
			otemp.css({
				left : p.x + "px",
				top : p.y + ny + "px",
				width : safe.width + "px",
				height : safe.height + "px",
				display : "block"
			});
		}
		;
		if (o.dstar != "" && $.isFunction(o.dstar))
			o.dstar(this);
	}, move = function(ev) {
		var parent;
		ev = ev || window.event;
		window.getSelection ? window.getSelection().removeAllRanges()
				: document.selection.empty();
		Util.clSelect();
		_x = ev.clientX - mx;
		_y = ev.clientY - my;
		if (o.parent != "") {
			parent = Util.getPosition(o.parent);
			op = Util.getPosition(o.obj);
			_x = ev.clientX - mx - parent.x;
			_y = ev.clientY - my - parent.y;
		}
		;
		maxX = o.parent != "" ? parent.width - op.width : safe.maxX;
		maxY = o.parent != "" ? parent.height - op.height : safe.maxY;
		if (o.lockX)
			_y = p.y;
		if (o.lockY)
			_x = p.x;
		if (o.lock) {
			if (_x <= 0)
				_x = safe.minX;
			if (_x >= maxX)
				_x = maxX;
			if (o.fixed) {
				if (_y <= 0)
					_y = safe.minY;
				if (_y >= maxY)
					_y = maxY;
			} else {
				if (_y > maxY + s.scrollTop)
					_y = maxY + s.scrollTop;
				if (_y < s.scrollTop)
					_y = s.scrollTop;
			}
		}
		;
		otemp.css({
			left : _x + "px",
			top : _y + "px"
		});
		if (o.dmove != "" && $.isFunction(o.dmove))
			o.dmove(this);
	}, stop = function(ev) {
		if (o.temp != "" && Util.config.drag) {
			otemp.css("display", "none");
			_this.css({
				left : _x + "px",
				top : _y + "px"
			});
		}
		;
		$(document).unbind("mousemove");
		if (o.obj.releaseCapture) {
			o.obj.releaseCapture();
		} else if (window.captureEvents) {
			window.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP);
		}
		if (o.dstop != "" && $.isFunction(o.dstop))
			o.dstop(this);
	};
};
Util.mDrag = function(a, b) {
	var bDrag = false;
	var disX = 0, disY = 0;
	var win = Util.getID(a);
	var obj = Util.getID(b);
	if (win && obj) {
		obj.onmousedown = function(event) {
			(event || window.event).cancelBubble = true;
		};
		win.onmousedown = function(event) {
			event = event || window.event;
			bDrag = true;
			disX = event.clientX - win.offsetLeft;
			disY = event.clientY - win.offsetTop;
			this.setCapture && this.setCapture();
			return false;
		};
		document.onmousemove = function(event) {
			if (!bDrag)
				return;
			event = event || window.event;
			var iL = event.clientX - disX;
			var iT = event.clientY - disY;
			var maxL = document.documentElement.clientWidth - win.offsetWidth;
			var maxT = document.documentElement.scrollHeight - win.offsetHeight;
			iL = iL < 0 ? 0 : iL;
			iL = iL > maxL ? maxL : iL;
			iT = iT < 0 ? 0 : iT;
			iT = iT > maxT ? maxT : iT;
			win.style.marginTop = win.style.marginLeft = 0;
			win.style.left = iL + 'px';
			win.style.top = iT + 'px';
			return false;
		};
		document.onmouseup = window.onblur = win.onlosecapture = function() {
			bDrag = false;
			win.releaseCapture && win.releaseCapture();
		};
	}
};

Util.Browser = function() {
	var a = navigator.userAgent.toLowerCase();
	var u = navigator.userAgent;
	var b = {};
	b.isStrict = document.compatMode == "CSS1Compat";
	b.isFirefox = a.indexOf("firefox") > -1;
	b.isOpera = a.indexOf("opera") > -1;
	b.isSafari = (/webkit|khtml/).test(a);
	b.isSafari3 = b.isSafari && a.indexOf("webkit/5") != -1;
	b.isIE = !b.isOpera && a.indexOf("msie") > -1;
	b.isIE6 = !b.isOpera && a.indexOf("msie 6") > -1;
	b.isIE7 = !b.isOpera && a.indexOf("msie 7") > -1;
	b.isIE8 = !b.isOpera && a.indexOf("msie 8") > -1;
	b.isGecko = !b.isSafari && a.indexOf("gecko") > -1;
	b.isMozilla = document.all != undefined
			&& document.getElementById != undefined
			&& !window.opera != undefined;
	b.isTrident = u.indexOf('Trident') > -1;
	b.isPresto = u.indexOf('Presto') > -1;
	b.isWebKit = u.indexOf('AppleWebKit') > -1;
	b.isGecko = u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1;
	b.isMobile = !!u.match(/AppleWebKit.*Mobile.*/) || !!u.match(/AppleWebKit/);
	b.isios = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/);
	b.isAndroid = u.indexOf('Android') > -1 || u.indexOf('Linux') > -1;
	b.isiPhone = u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1;
	b.isiPad = u.indexOf('iPad') > -1;
	b.isWebApp = u.indexOf('Safari') == -1;
	return b;
}();