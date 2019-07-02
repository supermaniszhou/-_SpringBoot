<%@ page contentType="text/html; charset=UTF-8" %>

<link rel="stylesheet" type="text/css" href="static/layui/css/layui.css"/>
<link rel="stylesheet" type="text/css" href="static/layui/css/selection_infomation.css"/>
<script type="text/javascript" src="static/layui/layui.js"></script>
<script type="text/javascript" src="static/jquery.js"></script>

<html>
<body>
<div class="layui-container">
    <div class="layui-row layui-col-space20">
        <div class="layui-col-xs6">
            <div class="grid-demo grid-demo-bg1">

                <div class="layui-card">
                    <div class="layui-table-header">
                        <div style="line-height: 30px;height: 30px;padding-left: 20px;">
                            人员信息
                        </div>
                    </div>
                </div>
                <div class="layui-tab">
                    <ul class="layui-tab-title">
                        <li class="layui-this">集团领导</li>
                        <li>党政办</li>
                        <li>机关部门</li>
                        <li>基层单位44</li>
                    </ul>
                    <div class="layui-tab-content">
                        <div class="layui-tab-item layui-show">
                            1. 高度默认自适应，也可以随意固宽。
                            <br>2. Tab进行了响应式处理，所以无需担心数量多少。
                        </div>
                        <div class="layui-tab-item">内容2</div>
                        <div class="layui-tab-item">内容3</div>
                        <div class="layui-tab-item">内容46666</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-col-xs6">
            <div class="layui-card">
                <div class="layui-table-header">
                    <div style="line-height: 30px;height: 30px;padding-left: 20px;">
                        已选择人员
                    </div>
                </div>
            </div>
            <!-- 已选择信息 -->
            <dl class="selected-info" style="height: 350px;"></dl>
            <div style="text-align: center">
                <div style="margin-top: 20px;"></div>
                <div class="layui-input-inline">
                    <button class="layui-btn" id="save">保存</button>

                    <button class="layui-btn" id="selected_info_reset">清空</button>
                </div>
            </div>
        </div>
    </div>

</div>


<script>
    layui.use('element', function () {
        var $ = layui.jquery;
        var element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        //触发事件
        var active = {

            tabChange: function () {
                //切换到指定Tab项
                element.tabChange('demo', '22'); //切换到：用户管理
            }
        };
    });
</script>


</body>
</HTML>