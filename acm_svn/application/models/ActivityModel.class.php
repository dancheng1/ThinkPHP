<?php
//活动Model
class ActivityModel extends Model{
    /**
     * 删除活动
     */
    public function delete($id){
        $sql = 'DELETE FROM cz_activity WHERE id = ' . $id;
        $this->db->query($sql);
    }

    /**
     * 修改活动
     */
    public function updateActivity($data){
        $sql = "UPDATE {$this->table} SET title = '" . $data['title'] . "', creator = '" . $data['creator'] . "', utime = '" . $data['utime'] . "', address = '" . $data['address'] . "', contact = '" . $data['contact'] . "', abstract = '" . $data['abstract'] . "', content = '" . $data['content'] . "', parent = " . $data['parent'] . " WHERE id = " . $data['id'];
        $this->db->query($sql);
    }

    /**
     * 查找所有活动
     */
    public function findAll($offset,$limit){
        $sql = "select * from {$this->table}  order by createtime desc limit $offset,$limit";
        return $this->db->getAll($sql);
    }

    /**
     * 查找比赛活动
     */
    public function findMatch($offset,$limit){
        $sql = "select * from {$this->table} where parent = 1  order by createtime desc limit $offset,$limit";
        return $this->db->getAll($sql);
    }

    /**
     * 查找培训活动
     */
    public function findTrain($offset,$limit){
        $sql = "select * from {$this->table} where parent = 2  order by createtime desc limit $offset,$limit";
        return $this->db->getAll($sql);
    }

    /**
     * 按id查找活动
     */
    public function findById($id){
        $sql = "select * from {$this->table} where id = " . $id;
        return $this->db->getRow($sql);
    }






    //----------------全使用-----------
    /**
     * 三个最新活动
     */
    public function findZuiXin(){
        $sql = "select * from {$this->table}  order by createtime desc";
        return $this->db->getAll($sql);
    }

    /**
     * 三个热门活动
     */
    public function findReMen(){
        $sql = "select * from {$this->table}  order by visit desc";
        return $this->db->getAll($sql);
    }
}