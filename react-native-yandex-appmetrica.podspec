require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
    s.name = package['name']
    s.version = package['version']
    s.summary = package['description']
    s.authors = package['author']
    s.license = { type: package['license'] }
    s.homepage = package['repository']['url']
    s.source = { git: package['repository']['url'] }
    s.source_files = "ios/appmetrica/*.{h,m}"
    s.platform = :ios, "8.0"

    s.dependency "React"
    s.dependency "YandexMobileMetrica/Dynamic", "~> 3.6.0"
    s.dependency "YandexMobileMetricaPush/Dynamic", "~> 0.7.2"
end