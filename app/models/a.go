package models

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
	log "github.com/sirupsen/logrus"
)

func init() {
	db, err := gorm.Open("mysql", "root:@/pageagg.com?charset=utf8&parseTime=True&loc=Local")
	db.LogMode(true)
	if err != nil {
		log.Error("database connection failed.")
	}
	// 启用Logger，显示详细日志
	db.Set("gorm:table_options", "ENGINE=InnoDB")
	db.AutoMigrate(&Comment{}, &Favorite{}, &Home{}, &Item{}, &Page{}, &Tag{}, &User{}, Widget{})
	// 关闭数据库连接
	defer db.Close()
}
