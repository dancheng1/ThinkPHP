<?php
namespace Model;
use Think\Model;
class RoleModel extends Model{
    public function updateRole($auth_id_array, $role_id){
        $auth_ids = implode(',', $auth_id_array);
        $auth = M('auth')->select($auth_ids);
        $array = array();
        foreach ($auth as $v){
            if(empty($v['auth_c']) || empty($v['auth_a']))
                continue;
            $array[] = $v['auth_c'] . '-' . $v['auth_a'];
        }
        $role_auth_ac = join(',', $array);
        $data['role_id'] = $role_id;
        $data['role_auth_ids'] = $auth_ids;
        $data['role_auth_ac'] = $role_auth_ac;
        return M('role')->save($data);
    }
}