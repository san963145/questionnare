$(function () {
    for (var i = 1; i < dataNode._select.length; i++) {
        var option = dataNode._select[i];
        var item = 'item' + i;
        var itemimg = option._item_img || '';
        if (itemimg) {
            var index = itemimg.indexOf("?x-oss-process=");
            if (index > -1) {
                var cimg = itemimg.substring(0, index) + "?x-oss-process=image/resize,m_fill,h_25,w_25";
                itemimg = " background-image:url(" + cimg + ");";
            }
            else
                itemimg = " background-image:url(" + itemimg + ");";
        }
        var def = option._item_radio ? ' jqchecked' : '';
        var ititle = option._item_title.replace('"', '').replace("'", "");
        var option_template = '<div class="sel_items"><div><label class="box"><input type="checkbox" class="cb" id="' + item + '"><a class="jqcheck' + def + '" href="javascript:;"></a></label><div class="input"><input placeholder="选项名称" value="' + ititle + '"/></div>';
        option_template = option_template + '<div class="addImg" style="' + itemimg + '"><input type="file" class="fileupload" /></div></div></div>';
        $("#option_list").append(option_template);

    }
    $("#question_title").bind("keydown", function (event) {
        if (event.keyCode == 13) {
            event.preventDefault();
            var firstInput = $("#option_list .input input").first();
            firstInput.focus();
            firstInput.val(firstInput.val());
        }
    });

    setInputWidth();
    if (isKaoShi) {
        $("#divkaoshi").show();
        $("#divksscore").show();
        $("#txtkaoshi").val(dataNode._ceshiDesc);
        $("#selscore").change(function () {
            dataNode._ceshiValue = parseInt(this.value) || 5;
            $(this).prev().text(this.options[this.selectedIndex].text);
        });
        $("#selscore").val(dataNode._ceshiValue);
        $("#selscore").change();
        $("#txtkaoshi").bind("change blur", function () {
            dataNode._ceshiDesc = $.trim(this.value);
        });
    }
    //显示多选题的最多选择设置
    if (dataNode._type == "check") {
        if (!dataNode._isCeShi) {
            $("#qmul_select_limit").show();
            $("#qmul_select_limitlist").show();
        }
        $("#type_multiple").addClass("active");
    } else {
        $("#type_single").addClass("active");
    }
    //选择单选多选类型
    $('.SelectType li').bind('click', function () {
        $(this).parent().find('li').removeClass('active');
        $(this).addClass('active');
        if (this.id == "type_single") {
            $("#qmul_select_limit").hide();
            $("#qmul_select_limitlist").hide();
            dataNode._type = "radio";
            var dml = "单选题";
            if (dataNode._isTouPiao)
                dml = "投票单选";
            else if (dataNode._isCeShi)
                dml = "考试单选";
            $("#spanQtype").html(dml);
        } else {
            if (!dataNode._isCeShi) {
                $("#qmul_select_limit").show();
                $("#qmul_select_limitlist").show();
            }
            dataNode._type = "check";
            var dml = "多选题";
            if (dataNode._isTouPiao)
                dml = "投票多选";
            else if (dataNode._isCeShi)
                dml = "考试多选";
            $("#spanQtype").html(dml);
        }
    });
    $("#qmul_select_limit_dom").change(function () {
        var val = $(this).val();
        $(this).prev().text(val);
        if (val === "不限") {
            dataNode._upLimit = "";
        } else {
            if (dataNode._lowLimit - 0 > 0 && val - dataNode._lowLimit < 0) {
                dataNode._upLimit = "";
                loadMack({ off: 'on', Limg: 0, text: '最多选择项不能小于最少选择项', set: 1500 });
                $(this).prev().text("不限");
                return;
            }
            dataNode._upLimit = val;
        }
    });
    $("#qmul_select_limit_up").change(function () {
        var val = $(this).val();
        $(this).prev().text(val);
        if (val === "不限") {
            dataNode._lowLimit = "";
        } else {
            if (dataNode._upLimit - 0 > 0 && val - dataNode._upLimit > 0) {
                dataNode._lowLimit = "";
                $(this).prev().text("不限");
                loadMack({ off: 'on', Limg: 0, text: '最少选择项不能大于最多选择项', set: 1500 });
                return;
            }
            dataNode._lowLimit = val;
        }
    });

    refresh_select_limit();
    if (dataNode._upLimit - 0 > 0) {
        $("#qmul_select_limit_dom").prev().text(dataNode._upLimit);
        $("#qmul_select_limit_dom").val(dataNode._upLimit);
    } else {
        $("#qmul_select_limit_dom").prev().text("不限");
    }
    if (dataNode._lowLimit - 0 > 0) {
        $("#qmul_select_limit_up").prev().text(dataNode._lowLimit);
        $("#qmul_select_limit_up").val(dataNode._lowLimit);
    } else {
        $("#qmul_select_limit_up").prev().text("不限");
    }
    //选项删除监听
    $('#option_list .input input').bind('blur', function () {
        isInputVal($(this));
    });

    $('.random').bind('click', function () {
        var isClass = $(this).is('.on');
        if (isClass) {
            $(this).removeClass('on').addClass('off');
            dataNode._randomChoice = false;
        } else {
            $(this).removeClass('off').addClass('on');
            dataNode._randomChoice = true;
        }
    });
    if (dataNode._randomChoice) {
        $(".random").addClass("on");
    } else {
        $(".random").addClass("off");
    }
});
function refresh_select_limit() {
    $("#qmul_select_limit_dom,#qmul_select_limit_up").html("<option value='不限'>不限</option>");
    for (var i = 1; i < dataNode._select.length; i++) {
        $("#qmul_select_limit_dom,#qmul_select_limit_up").append('<option value="' + (i) + '">' + (i) + '</option>');
    }
}
function setInputWidth() {
    var inputWidth = $("#option_list").width() - 94;
    $("#option_list .input").width(inputWidth);
}
function random_string(len) {
    len = len || 32;
    var chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';
    var maxPos = chars.length;
    var pwd = '';
    for (i = 0; i < len; i++) {
        pwd += chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return pwd;
}

function get_suffix(filename) {
    pos = filename.lastIndexOf('.')
    suffix = ''
    if (pos != -1) {
        suffix = filename.substring(pos)
    }
    return suffix;
}
function uploadFile(e) {
    var file = e.target.files[0]; //获取图片资源
    var filename = file.name;

    if (!file.type.match('image.*')) {
        alert("只能添加图片文件！");
        return false;
    }
    var inputFile = this;
    inputFile.parentNode.style.backgroundImage = "url('/images/WJX/award/loader.gif')";
    lrz(file, { width: 400 }).then(function (rst) {
        var ossData = new FormData();
        var file = rst.file;
        // 先请求授权，然后回调
        $.getJSON('/handler/getoss.ashx?activity=' + activityId, function (json) { //签名用的PHP
            // 添加签名信息
            ossData.append('OSSAccessKeyId', json.accessid);
            ossData.append('policy', json.policy);
            ossData.append('Signature', json.signature);
            var keyname = json.dir + Date.parse(new Date()) / 1000 + random_string(10) + get_suffix(filename);
            ossData.append('key', keyname);
            ossData.append('file', file, filename);
            $.ajax({
                url: json.host,
                data: ossData,
                processData: false,
                contentType: false,
                type: 'POST',
                success: function () {
                    var baseUrl = '//pubalifr.sojump.com/' + keyname;
                    var url = baseUrl + '?x-oss-process=image/resize,w_400';
                    if (file.size && file.size - 400 * 1024 > 0)
                        url += "/quality,q_85";
                    inputFile.parentNode.style.backgroundImage = "url('" + baseUrl + '?x-oss-process=image/resize,m_fill,h_25,w_25' + "')";
                    inputFile.imgname = url;
                    isInputVal($(inputFile), 2);
                    //$("#preview_box").empty().append('<img class="preview" src="' + url+ '" alt="preview"/>');
                }
            });
        });
        return rst;
    })
   .catch(function (err) {
       alert('错误信息：' + err);
   })
   .always(function () {
   });
}
function BindDefaultEvent() {
    var objs = $("#option_list .jqcheck");
    objs.unbind("click");
    objs.bind("click", function () {
        if (dataNode._type=="check" && dataNode._tag) {
            loadMack({ off: 'on', Limg: 0, text: '排序题不支持默认选项！', set: 500 });
            return false;
        }
        $(this).toggleClass("jqchecked");
        isInputVal($(this), 3);
    });
}
function BindUploadEvent() {
    var objs = $("#option_list .fileupload");
    objs.unbind("change");
    objs.bind("change", uploadFile);
}
function BindEnterEvent() {
    var allInputs = $("#option_list .input input");
    allInputs.unbind("keydown");
    $(allInputs).bind("keydown", function (event) {
        if (event.keyCode == 13) {
            event.preventDefault();
            event.stopPropagation();
            var index = allInputs.index(this);
            if (index < allInputs.length - 1) {
                var nInput = $(allInputs[index + 1]);
                nInput.focus();
                nInput.val(nInput.val());
            }
        }
    });
}
$(function () {
    BindUploadEvent();
    BindDefaultEvent();
    BindEnterEvent();
});