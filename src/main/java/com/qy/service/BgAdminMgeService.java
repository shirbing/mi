package com.qy.service;

import com.qy.domain.AdminEntity;

import java.util.List;

public interface BgAdminMgeService {
    public boolean BgAdminAdd(AdminEntity adminEntity);
    public List<AdminEntity> BgAdminList(int currentpage);
    public boolean BgAdmindelete(AdminEntity adminEntity);
}
