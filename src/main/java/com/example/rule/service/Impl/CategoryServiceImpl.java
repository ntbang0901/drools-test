package com.example.rule.service.Impl;

import com.example.rule.entity.CategoryEntity;
import com.example.rule.repository.CategoryRepository;
import com.example.rule.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    List<String> listCategories = Arrays.asList("Điện thoại", "Điện tử", "Điện lạnh", "Điện gia dụng", "Đồ dùng",
            "Phụ kiện", "Thực phẩm tươi sống", "Thiết bị làm đẹp", "Sức khỏe", "Dụng cụ sửa chữa",
            "Thực phẩm đóng gói", "Đồ uống", "Bánh kẹo", "Thời trang", "Chăm sóc cá nhân", "Vệ sinh nhà cửa", "Sản phẩm chăm sóc thú cưng",
            "Dịch vụ sức khỏe", "Gói cước truyền hình", "Dịch vụ vận chuyển", "Dịch vụ lắp đặt", "Dịch vụ bảo hành - bảo dưỡng",
            "Dịch vụ sửa chữa", "Dịch vụ đi chợ Online", "Dịch vụ làm sạch", "Dịch vụ bảo trì", "Dịch cụ đổi trả",
            "Dịch vụ thanh toán hộ", "Dịch vụ Bảo hiểm xe máy - ô tô", "Dịch vụ Sim số");
    @Override
    public void insertData() {
        for(int i = 1; i<= listCategories.size(); i++) {
            CategoryEntity categoryEntity = new CategoryEntity();
            UUID uuid = UUID.randomUUID();
            categoryEntity.setCategoryId(uuid);
            categoryEntity.setCategoryName(listCategories.get(i-1));
            categoryRepository.save(categoryEntity);
        }
    }
}
