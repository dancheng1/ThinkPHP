<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <meta http-equiv=content-type content="text/html; charset=utf-8" />
        <link href="../../../Application/Admin/Public/css/admin.css" type="text/css" rel="stylesheet" />
        <script language=javascript>
            function expand(el)
            {
                childobj = document.getElementById("child" + el);

                if (childobj.style.display == 'none')
                {
                    childobj.style.display = 'block';
                }
                else
                {
                    childobj.style.display = 'none';
                }
                return;
            }
        </script>
    </head>
    <body>
        <table height="100%" cellspacing=0 cellpadding=0 width=170 
               background=../../../Application/Admin/Public/img/menu_bg.jpg border=0>
            <tr>
                <td valign=top align=middle>
                    <table cellspacing=0 cellpadding=0 width="100%" border=0>
                        <tr>
                            <td height=10></td>
                        </tr>
                    </table>

                    <?php if(is_array($info1)): $i = 0; $__LIST__ = $info1;if( count($__LIST__)==0 ) : echo "" ;else: foreach($__LIST__ as $key=>$vo1): $mod = ($i % 2 );++$i;?><table cellspacing=0 cellpadding=0 width=150 border=0>
                        <tr height=22>
                            <td style="padding-left: 30px" background=../../../Application/Admin/Public/img/menu_bt.jpg><a
                                    class=menuparent onclick=expand(<?php echo ($vo1["auth_id"]); ?>)
                                    href="javascript:void(0);"><?php echo ($vo1["auth_name"]); ?></a>
                            </td>
                        </tr>
                        <tr height=4>
                            <td></td>
                        </tr>
                    </table>
                        <table id=child<?php echo ($vo1["auth_id"]); ?> style="display: none" cellspacing=0 cellpadding=0
                               width=150 border=0>
                        <?php if(is_array($info2)): $i = 0; $__LIST__ = $info2;if( count($__LIST__)==0 ) : echo "" ;else: foreach($__LIST__ as $key=>$vo2): $mod = ($i % 2 );++$i; if($vo2['auth_pid'] == $vo1['auth_id']): ?><tr height=20>
                                <td align=middle width=30><img height=9
                                                               src="../../../Application/Admin/Public/img/menu_icon.gif" width=9></td>
                                <td><a class=menuchild
                                       href="/ThinkPHP/index.php/Admin/<?php echo ($vo2["auth_c"]); ?>/<?php echo ($vo2["auth_a"]); ?>"
                                       target=main><?php echo ($vo2["auth_name"]); ?></a>
                                </td>
                            </tr><?php endif; endforeach; endif; else: echo "" ;endif; ?>
                            <tr height=4>
                                <td colspan=2></td>
                            </tr>
                        </table><?php endforeach; endif; else: echo "" ;endif; ?>




                    </td>
                <td width=1 bgcolor=#d1e6f7></td>
            </tr>
        </table>
    </body>
</html>