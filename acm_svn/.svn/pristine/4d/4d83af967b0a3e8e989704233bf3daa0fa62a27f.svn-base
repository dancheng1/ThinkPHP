<?php
//资源模型类
class ResourceModel extends Model{
    /**
     * 修改浏览次数
     */
    public function updateVisit($id, $num){
        $sql = "UPDATE cz_resource SET visit = " . $num . " WHERE id = " . $id;
        return $this->db->query($sql);
    }

    /**
     * 删除资源
     */
    public function deleteByResId($id){
        $sql = "delete from cz_resource where id = " . $id;
        return $this->db->query($sql);
    }

    /**
     * 修改图片
     */
    public function updateResTp($id, $set){
        $sql = "UPDATE cz_resource SET " . $set . " WHERE id = " . $id;
        return $this->db->query($sql);
    }

    /**
     * 修改资源信息
     */
    public function updateRes($data){
        $sql = "UPDATE cz_resource SET NAME = '" . $data['name'] . "', creator = '" . $data['creator'] . "', link = '" . $data['link'] . "', PASSWORD = '" . $data['password'] . "', abstract = '" . $data['abstract'] . "', content = '" . $data['content'] . "', parent_id = " . $data['parent_id'] . ", LEVEL = " . $data['level'] . " WHERE id = " . $data['id'];
        return $this->db->query($sql);
    }

    /**
     * 根据大分类查询小分类
     */
    public function AfindTypeByParentId($parent){
        $sql = "SELECT	* FROM {$this->table} WHERE parent = " . $parent;
        return $this->db->getAll($sql);
    }

    /**
     * 根据资源分类名查找资源
     */
    public function AfindTypeByName($name){
        $sql = "SELECT	* FROM {$this->table} WHERE NAME = '" . $name . "'";
        return $this->db->getRow($sql);
    }

    /**
     * 后台的根据分类查询所有资源
     */
    public function AfindByTypeId($where,$offset,$limit){
        if(empty($where)){
            $sql = "SELECT * FROM {$this->table} limit $offset,$limit";
        }else{
            $sql = "SELECT * FROM {$this->table} where $where limit $offset,$limit";
        }
        return $this->db->getAll($sql);
    }

    /**
     * 后台查找笔录
     */
    public function AfindNode($offset,$limit){
        $sql = "select * from {$this->table} where parent_parent = 2 limit $offset,$limit";
        return $this->db->getAll($sql);
    }

    /**
     * 后台查找书籍
     */
    public function AfindBook($offset,$limit){
        $sql = "select * from {$this->table} where parent_parent = 3 limit $offset,$limit";
        return $this->db->getAll($sql);
    }


    /**
     * 查找笔录
     */
    public function findNode($offset,$limit){
        $sql = "select * from {$this->table} where parent = 2 limit $offset,$limit";
        return $this->db->getAll($sql);
    }

    /**
     * 查找书籍
     */
    public function findBook($offset,$limit){
        $sql = "select * from {$this->table} where parent = 3 limit $offset,$limit";
        return $this->db->getAll($sql);
    }

    /**
     * 查找Video
     */
    public function findVideo($offset,$limit){
        $sql = "select * from {$this->table} where parent = 1 limit $offset,$limit";
        return $this->db->getAll($sql);
    }

    /**
     * 根据分类查询所有资源
     */
    public function findByTypeId($id,$offset,$limit){
        $sql = "SELECT * FROM {$this->table} WHERE parent_id = " . $id . " limit $offset,$limit";
        return $this->db->getAll($sql);
    }

    /**
     * 按id查找资源
     */
    public function findById($id){
        $sql = "SELECT * FROM {$this->table} WHERE id = " . $id;
        return $this->db->getRow($sql);
    }

    /**
     * 根据分类id查询下面所有资源
     */
    public function findresByTypeId($id){
        $sql = "SELECT * FROM cz_resource WHERE parent_id = " . $id;
        return $this->db->getAll($sql);
    }

    /**
     * 按id删除分类
     */
    public function deleteType($id){
        $sql = "DELETE FROM {$this->table} WHERE id = " . $id;
        return $this->db->query($sql);
    }

    /**
     * 修改分类图片
     */
    public function updateTypeTuPian($id,$url){
        $sql = "UPDATE {$this->table} SET img_url = '" . $url . "' WHERE id = " . $id;
        return $this->db->query($sql);
    }

    /**
     * 修改分类信息
     */
    public function updateType($data){
        $sql = "UPDATE {$this->table} SET parent = " . $data['parent'] . ", name = '" . $data['name'] . "', content = '" . $data['content'] . "' WHERE id = " . $data['id'];
        return $this->db->query($sql);
    }

    /**
     * 查询全部分类信息
     */
    public function findAll($offset,$limit){
        $sql = "select * from {$this->table} limit $offset,$limit";
        return $this->db->getAll($sql);
    }


}