package com.mivio.wallet.core.service

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

// Lớp này kế thừa NotificationListenerService để có khả năng lắng nghe thông báo
class BankNotificationService : NotificationListenerService() {

    // Hàm này được Android tự động gọi mỗi khi điện thoại nhận được một thông báo mới
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)

        // sbn chứa toàn bộ thông tin của thông báo.
        // Lấy tên gói ứng dụng (ví dụ: com.vcb, com.tpb...) để biết app nào gửi thông báo
        val packageName = sbn?.packageName ?: return

        // Lấy dữ liệu chi tiết của thông báo
        val extras = sbn.notification?.extras
        val title = extras?.getString("android.title") // Tiêu đề thông báo
        val text = extras?.getCharSequence("android.text")?.toString() // Nội dung thông báo

        // Nếu thông báo có chứa chữ, chúng ta sẽ xử lý nó
        if (title != null && text != null) {
            // In ra màn hình Log (công cụ theo dõi của lập trình viên) để bạn xem thử
            Log.d("DongTienApp", "-----------------------")
            Log.d("DongTienApp", "Ứng dụng gửi: $packageName")
            Log.d("DongTienApp", "Tiêu đề: $title")
            Log.d("DongTienApp", "Nội dung: $text")

            // Tạm thời chúng ta dừng ở việc in ra. Ở các bước sau, chúng ta sẽ thêm
            // mã vào đây để lọc ra số tiền từ biến 'text' nhé!
        }
    }
}