<?php
//用户
class UserModel extends Model{
//--------------------------------------------------------------------------------------------
//------------------------------后台跳转-------------------------------------------------------
//--------------------------------------------------------------------------------------------
    public function AfindByLevel(){
        $sql = "SELECT * FROM {$this->table} WHERE LEVEL = 0";
        return $this->db->getAll($sql);
    }

    /**
     * 分页获取人员列表
     * @param $offset
     * @param $limit
     * @return array
     */
    public function getPageUsers($offset,$limit){
        $sql = "select * from {$this->table}  limit $offset,$limit";
        return $this->db->getAll($sql);
    }

    /**
     * 按级别获取人员列表
     * @param $offset
     * @param $limit
     * @param $level
     * @return array
     */
    public function getPageLevelUsers($offset,$limit,$level){
        $sql = "select * from {$this->table} where level = '" . $level . "'  limit $offset,$limit";
        return $this->db->getAll($sql);
    }

    /**
     * 按Id名查询
     */
    public function AfindByUserId($id){
        $sql = "SELECT * FROM {$this->table} WHERE id = '" . $id . "'";
        return $this->db->getRow($sql);
    }

    /**
     * 修改基本信息
     */
    public function AupdateInformation($data){
        $sql = "UPDATE {$this->table} SET acm_name = '" . $data['acm_name'] . "', acm_sex = '" . $data['acm_sex'] . "', acm_tel = '" . $data['acm_tel'] . "', acm_qq = '" . $data['acm_qq'] . "', acm_school = '" . $data['acm_school'] . "', acm_college = '" . $data['acm_college'] . "', acm_system = '" . $data['acm_system'] . "', acm_class = '" . $data['acm_class'] . "', acm_hobby = '" . $data['acm_hobby'] . "', acm_self = '" . $data['acm_self'] . "' WHERE id = '" . $data['id'] . "'";
        return $this->db->query($sql);

    }

    /**
     * 按id删除信息
     */
    public function AdeleteById($id){
        $sql = "DELETE FROM {$this->table} WHERE id = " . $id;
        return $this->db->query($sql);
    }

    /**
     * 查询全部未审核会员
     */
    public function findAllLevelLing(){
        $sql = "select * from {$this->table} where level = 0 order by createtime desc";
        return $this->db->getAll($sql);
    }

    /**
     * 通过审核，根据id设置level=2
     */
    public function updateGoLevel($id){
        $sql = "UPDATE cz_user SET LEVEL = 1, acm_position = '会员' WHERE id = " . $id;
        return $this->db->query($sql);
    }

    /**
     * 查找除了未审核的全部人员
     * @return array
     */
    public function findAllNoLevelLing(){
        $sql = "select * from {$this->table} where level != 0 order by createtime desc";
        return $this->db->getAll($sql);
    }

    /**
     * 修改等级
     */
    public function upLevel($id, $level, $str){
        $sql = "UPDATE {$this->table} SET LEVEL = " . $level . ", acm_position = '" . $str . "' WHERE id = " . $id;
        return $this->db->query($sql);
    }

    /**
     * 根据id写入备注
     */
    public function addremark($id, $remark){
        $sql = "UPDATE {$this->table} SET remark = '" . $remark . "' WHERE id = " . $id;
        return $this->db->query($sql);
    }

    /**
     * 根据id修改密码
     */
    public function upPssw($id, $password, $username){
        $password = md5($password);
        $sql = "UPDATE {$this->table} SET acm_username = '" . $username . "', acm_password = '" . $password . "' WHERE id = " . $id;
        return $this->db->query($sql);
    }




//--------------------------------------------------------------------------------------------
//------------------------------前台跳转-------------------------------------------------------
//--------------------------------------------------------------------------------------------
    /**
     * 求会员的个数
     */
    public function findAllNum(){
        $sql = 'SELECT COUNT(*) as num FROM cz_user';
        $result = $this->db->getAll($sql);
        return $result[0]['num'];
    }

    /**
     * 求干事个数
     */
    public function findMohamedNum(){
        $sql = 'SELECT COUNT(*) as num FROM cz_user where level = 3';
        $result = $this->db->getAll($sql);
        return $result[0]['num'];
    }

    /**
     * 求老师个数
     */
    public function findTeacherNum(){
        $sql = 'SELECT COUNT(*) as num FROM cz_user where level = 5';
        $result = $this->db->getAll($sql);
        return $result[0]['num'];
    }

    /**
     * 修改基本信息
     */
    public function updateInformation($data){
        $sql = "UPDATE {$this->table} SET acm_name = '" . $data['acm_name'] . "', acm_sex = '" . $data['acm_sex'] . "', acm_tel = '" . $data['acm_tel'] . "', acm_qq = '" . $data['acm_qq'] . "', acm_hobby = '" . $data['acm_hobby'] . "', acm_self = '" . $data['acm_self'] . "' WHERE acm_username = '" . $data['acm_username'] . "'";
        return $this->db->query($sql);

    }

    /**
     * 按用户名查询
     */
    public function findByUserName($username){
        $sql = "SELECT * FROM {$this->table} WHERE acm_username = '" . $username . "'";
        return $this->db->getRow($sql);
    }

    /**
     * 修改成超级会员
     */
    public function HupdateLevel($username){
        $sql = "UPDATE {$this->table} SET LEVEL = 2, acm_position = '超级会员' WHERE acm_username = '" . $username . "'";
        return $this->db->query($sql);
    }

    /**
     * 根据用户名修改级别
     */
    public function updateLevel($username, $level){
        $sql = "UPDATE {$this->table} SET LEVEL = " . $level . " WHERE acm_username = '" . $username . "'";
        return $this->db->query($sql);
    }

    /**
     * 根据用户名修改头像
     */
    public function updateImg($username, $url){
        $sql = "UPDATE {$this->table} SET img_url = '" . $url . "' WHERE acm_username = '" . $username . "'";
        return $this->db->query($sql);
    }

    /**
     * 验证用户名和密码
     */
    public function checkUser($username, $password){
        $password = md5($password);
        $sql = "select * from {$this->table} where acm_username = '" . $username . "' and acm_password = '" . $password . "' limit 1";
        return $this->db->getRow($sql);
    }
}