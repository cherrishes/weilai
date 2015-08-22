freezer = {
	notify : function (c, a, d, b) {
		android.notify(c, a, d, b)
	},
	vibration : function (a) {
		android.vibration(a)
	},
	message : function (a) {
		android.message(a)
	},
	selectback : {},
	showSelect : function (b, a, c) {
		this.selectback = c;
		android.showSelect(b, a)
	},
	openNewUrlWindow : function (a) {
		android.openNewUrlWindow(a)
	},
	rbtncallback : {},
	setRightButton : function (a, b) {
		this.rbtncallback = b;
		android.setRightButton(a)
	},
	rbtnokback : {},
	showRightOk : function (a) {
		this.rbtnokback = a;
		android.showRightOk()
	},
	closeWindow : function (a) {
		android.closeWindow(a)
	},
	setBackEnable : function (a) {
		android.setBackEnable(a)
	},
	getAppVersion : function () {
		return android.getAppVersion()
	},
	getToken : function () {
		return android.getToken()
	}
};
