package util

import (
	"github.com/bwmarrin/snowflake"
	log "github.com/sirupsen/logrus"
	"math"
	"strconv"
	"strings"
)

var tenToAny map[int]string = map[int]string{0: "0", 1: "1", 2: "2", 3: "3", 4: "4", 5: "5", 6: "6", 7: "7", 8: "8", 9: "9", 10: "a", 11: "b", 12: "c", 13: "d", 14: "e", 15: "f", 16: "g", 17: "h", 18: "i", 19: "j", 20: "k", 21: "l", 22: "m", 23: "n", 24: "o", 25: "p", 26: "q", 27: "r", 28: "s", 29: "t", 30: "u", 31: "v", 32: "w", 33: "x", 34: "y", 35: "z", 36: "A", 37: "B", 38: "C", 39: "D", 40: "E", 41: "F", 42: "G", 43: "H", 44: "I", 45: "J", 46: "K", 47: "L", 48: "M", 49: "N", 50: "O", 51: "P", 52: "Q", 53: "R", 54: "S", 55: "T", 56: "U", 57: "V", 58: "W", 59: "X", 60: "Y", 61: "Z"}

/*
	10进制转任意进制
 */
func DecimalToAny(num uint64, n uint64) string {
	newNumStr := ""
	var remainder int
	var remainderString string
	for num != 0 {
		remainder = int(num % n)
		if 62 > remainder && remainder > 9 {
			remainderString = tenToAny[remainder]
		} else {
			remainderString = strconv.Itoa(remainder)
		}
		newNumStr = remainderString + newNumStr
		num = num / n
	}
	return newNumStr
}

/*
	map根据value找key
*/
func Findkey(in string) int {
	result := -1
	for k, v := range tenToAny {
		if in == v {
			result = k
		}
	}
	return result
}

/*
	任意进制转10进制
*/
func AnyToDecimal(num string, n int) int {
	var new_num float64
	new_num = 0.0
	nNum := len(strings.Split(num, "")) - 1
	for _, value := range strings.Split(num, "") {
		tmp := float64(Findkey(value))
		if tmp != -1 {
			new_num = new_num + tmp*math.Pow(float64(n), float64(nNum))
			nNum = nNum - 1
		} else {
			break
		}
	}
	return int(new_num)
}

/*
	生成Snowflake ID
 */
func SnowflakeID() (id uint64, idString string) {
	NodeIDStr := GetEnv("NODE_ID", "1")
	NodeID, err := strconv.ParseInt(NodeIDStr, 10, 64)
	if err != nil {
		log.Error(err)
		return
	}
	node, err := snowflake.NewNode(NodeID)
	if err != nil {
		log.Error(err)
		return
	}
	id = uint64(node.Generate())
	//log.Info("snowflake id generated.")
	idString = DecimalToAny(id, 62)
	return
}
