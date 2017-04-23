
                function $$(id) { return document.getElementById(id); }
                var qType=1;
                function NextStep() {
                    window.location.href = "/mysojump/createblank.aspx?qt=" + qType;
                }
                var ulLeft = $$("ulLeft");
                var hrefAs = ulLeft.getElementsByTagName("a");
                var prevTab = null; var prevA = null;

                var prevTona = null; var prevAba = null;
                for (var i = 0; i < hrefAs.length; i++) {
                    var ca = hrefAs[i];
                    ca.onclick = function () {
                        if (this == prevA) return;
                        var index = this.getAttribute("index");
                        qType = parseInt(index);
                        var tabId = "DivTab" + index;
                        var divTab = $$(tabId);
                        divTab.style.display = "";
                        this.className = "wactive";
                        if (prevTab) {
                            prevTab.style.display = "none";
                            prevA.className = "";
                        }
                       
                        prevTab = divTab;
                        prevA = this;
                        if (prevTona) {
                            prevTona.style.display = "none";
                            prevAba.className = "";
                        }
                        var ulLeft2 = $$("ulLeft" + index);
                        var divta = "DivTon" + index;
                        var hrefAs2 = ulLeft2.getElementsByTagName("a");
                        for (var i = 0; i < hrefAs2.length; i++) {
                            var ca = hrefAs2[i];
                            ca.onclick = function () {
                                if (this == prevAba) return;
                                var indexa = this.getAttribute("index");
                                var tabId = divta + indexa;
                                var DivTon = $$(tabId);
                                DivTon.style.display = "";
                                if (hrefAs2.length == 4) {
                                    this.className = "wactive1";
                                }
                                else {
                                    this.className = "wactive2";
                                }
                                if (prevTona) {
                                    prevTona.style.display = "none";
                                    prevAba.className = "";
                                }
                                var imgs = DivTon.getElementsByTagName("img");
                                for (var i = 0; i < imgs.length; i++) {
                                    if (!imgs[i].hasSrc) {
                                        var xsrc = imgs[i].getAttribute("xsrc");
                                        if (xsrc) {
                                            //alert(xsrc);
                                            imgs[i].hasSrc = true;
                                            imgs[i].src = xsrc;
                                        }
                                    }
                                }
                                //alert(this.className);
                                prevTona = DivTon;
                                prevAba = this;
                            }
                        }
                        hrefAs2[0].onclick();
                    }
                }
                hrefAs[qType-1].onclick();