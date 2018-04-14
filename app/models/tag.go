package models

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

const (
	TAG_TYPE_USER   = 1 // 用户tag
	TAG_TYPE_PAGE   = 2 // 页面tag
	TAG_TYPE_WIDGET = 3 // 组件tag
)

type Tag struct {
	gorm.Model
	TagType uint
}

// 多表关联，user_tags/page_tags/widget_tags
