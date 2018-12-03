package com.qy.dao;

import com.qy.domain.AdminEntity;

import java.util.List;

public interface BgAdminMgeDao {
    public boolean BgAdminAdd(AdminEntity adminEntity);
    public List<AdminEntity> BgAdminList(int currentpage);
    public boolean BgAdmindelete(AdminEntity adminEntity);
}
